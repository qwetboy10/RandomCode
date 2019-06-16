import Data.List.Split
main = do
	contents <- readFile "data.txt"
	print $ chunksOf 4 $ map removeLastCharacter $ lines contents
removeLastCharacter x = init x
