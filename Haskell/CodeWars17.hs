main = interact prob3

prob3 :: String -> String
prob3 input = 
    let allLines = lines input
        nums = map (\x -> (read x :: Double) * 0.299792) allLines
    in unlines $ map show nums

prob6 :: String -> String
prob6 input = 

delta :: Int -> [Int] -> [Int]
