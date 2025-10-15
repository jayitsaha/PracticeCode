class Solution:  # 44 ms, faster than 86.16%
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordSet = set(wordList)  # to check if a word is existed in the wordSet, in O(1)
        wordSet.discard(beginWord)

        def neighbors(word):
            for i in range(len(word)):  # change every possible single letters and check if it's in wordSet
                for c in ascii_lowercase:
                    newWord = word[:i] + c + word[i + 1:]
                    if newWord in wordSet:
                        yield newWord

        level = {}
        level[beginWord] = [[beginWord]]  # level[word] is all possible sequence paths which start from beginWord and end at `word`.
        while level:
            nextLevel = defaultdict(list)
            for word, paths in level.items():
                if word == endWord:
                    return paths  # return all shortest sequence paths
                for nei in neighbors(word):
                    for path in paths:
                        nextLevel[nei].append(path + [nei])  # form new paths with `nei` word at the end
            wordSet -= set(nextLevel.keys())  # remove visited words to prevent loops
            level = nextLevel  # move to new level

        return []
