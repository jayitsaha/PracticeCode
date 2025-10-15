# Python implementation
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        outer = [[]]
        for num in nums:
            n = len(outer)
            for i in range(n):
                internal = outer[i] + [num]
                outer.append(internal)
        return outer
