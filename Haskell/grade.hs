{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE RecordWildCards #-}

import qualified System.Console.ANSI as ANSI
import System.Environment
import Data.List
import qualified Data.Map as Map
import System.Process

main = do
    args <- getArgs
    let argMap = parseArgs args
        hasOutputFile =  Map.lookup Output argMap
        hasInputFile = Map.lookup Input argMap
    if args !! 0 == "test"
    then diff [] []
    else case hasInputFile of
            Just (Value True) -> do
                            stin <- getContents
                            dat <- compileStandardIn (args !! 0) (lines stin)
                            checkOutputFile hasOutputFile dat
            Just (Value False) -> do
                            dat <- compile (args !! 0)
                            checkOutputFile hasOutputFile dat

checkOutputFile :: Maybe ArgValue -> [String] -> IO ()
checkOutputFile (Just StandardOut) dat = printLines dat
checkOutputFile (Just (Path a)) dat = do
            contents <- readFile a
            if grade (lines contents) dat then putStrLn "Correct" else putStrLn "Wrong"

diff :: [String] -> [String] -> IO ()
diff _ _ = do
    createProcess ((shell "vimdiff <(echo a) <(echo b)") { new_session = True})
    putStrLn "what"

printLines :: [String] -> IO ()
printLines [] = return ()
printLines (x:xs) = do
                    putStrLn x
                    printLines xs

compile :: String -> IO [String]
compile fileName = do
    readProcess "javac" [fileName++".java"] ""
    output <- readProcess "java" [fileName] ""
    return (lines output)

compileStandardIn :: String -> [String] -> IO [String]
compileStandardIn fileName stin = do
    readProcess "javac" [fileName++".java"] ""
    output <- readProcess "java" [fileName] (unlines stin)
    return (lines output)

grade :: [String] -> [String] -> Bool
grade a b = and $ map (\(x,y) -> x == y) $ zip a b

parseArgs :: [String] -> Map.Map Arg ArgValue
parseArgs s = parseArgsR s $ Map.fromList defaultArgs

parseArgsR :: [String] -> Map.Map Arg ArgValue -> Map.Map Arg ArgValue
parseArgsR [] map = map
parseArgsR ("-i":xs) map = parseArgsR xs (Map.insert Input (Value True) map)
parseArgsR ("-o":b:xs) map = parseArgsR xs (Map.insert Output (Path b) map)
parseArgsR ("-d":xs)   map = parseArgsR xs (Map.insert Diff (Value True) map)
parseArgsR ("-f":b:xs) map = parseArgsR xs (Map.insert Problem (Path b) map)
parseArgsR (a:xs) map = parseArgsR xs map

defaultArgs = 
    [(Input,Value False)
    ,(Output,StandardOut)
    ,(Diff,Value False)]

data Arg = Input | Output | Diff | Problem deriving (Show,Ord,Eq)
data ArgValue = Path FilePath | StandardIn | StandardOut | Value Bool deriving (Show,Eq)
