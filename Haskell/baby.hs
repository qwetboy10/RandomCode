import Data.List hiding (subsequences)
import Data.Function
lis a = concat $ last $ sortByLength $ filter increasing $ subsequences a
subsequences a = filter (\x -> length x > 0) $ concat $ map inits $ tails a
sortByLength a = groupBy ((==) `on` length) $ sortBy (compare `on` length) a
increasing :: (Ord a) => [a] -> Bool
increasing [] = True
increasing [a] = True
increasing [a,b] = a <= b
increasing (a:b:xs) = (a <= b) && (increasing (b:xs)) 

qs :: (Ord a) => [a] -> [a]
qs [] = []
qs (x:xs) = qs [ a | a <- xs, a < x] ++ [x] ++ qs [a | a <- xs, a > x]
