module Dodge where

type Player = Int

data Point = Int Int deriving (Eq,Show)
data Direction = West | East deriving (Eq,Show)

data Game = Game
    { player :: Player
    , dead :: Bool
    , paused :: Bool
    , score :: Int
    } deriving (Show)

move :: Game -> Direction -> Game
move g West = g {player = (player g) - 1}

changePosition :: Int -> Int -> (Int,Int) -> Int
changePosition pos delta (min,max) = 
    where p = pos + delta

insideRange :: Int -> (Int,Int) -> Int
