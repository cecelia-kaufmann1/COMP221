import math
import os
import random
import re
import sys


def balancedSums(arr):
    """the function balancedSums take in an array
    of integers and you must determine if it fits a set of
    criteria. If yes, it will return a string "Yes"
    and otherwise, return a string "No"."""
    leftSum = 0
    right = sum(arr)
    for i in range(len(arr)):
        pivot = arr[i]
        right -= pivot
        if leftSum == right:
            return 'YES'
        leftSum += pivot
    return 'NO'



if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    T = int(input().strip())

    for T_itr in range(T):
        n = int(input().strip())

        arr = list(map(int, input().rstrip().split()))

        result = balancedSums(arr)

        fptr.write(result + '\n')

    fptr.close()



