class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root: return
        nodes = []
        
        def preorder(node):
            if not node: return
            nodes.append(node)
            preorder(node.left)
            preorder(node.right)
        
        preorder(root)
        for i in range(len(nodes) - 1):
            nodes[i].left = None
            nodes[i].right = nodes[i + 1]
