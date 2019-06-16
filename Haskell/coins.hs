import Data.Vector ((!),generate)
import Data.Maybe(mapMaybe)

main :: IO ()
main = do c <- getLine
          putStrLn $ show ( coins (read c :: Int) [1,5,10,25])

coins :: (Num a,Ord a) => Int -> [Int] -> a
coins sum c = r!sum
  where
    r = generate (sum+1) f
    options i = mapMaybe (\x -> justIf (i-x>=0) (r!(i-x))) c
    f i
      | i == 0 = 0
      | elem i c = 1
      | otherwise = options i >>> minimum >>> (+1) 


(>>>) :: a -> (a -> b) -> b
x >>> y = y x

justIf :: Bool -> a -> Maybe a
justIf True a = Just(a)
justIf False a = Nothing
