package com.tree;
//***
//前缀树
//参考：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
public class Trie_208 {
	private TrieNode root;

	public Trie_208() {
		root = new TrieNode();
	}

	// 插入
	// 时间复杂度：O(m)
	// 空间复杂度：O(m)
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!node.containsKey(currentChar)) {
				node.put(new TrieNode(), currentChar);
			}
			node = node.get(currentChar);
		}
		node.setEnd();
	}

	// 查找键
//	从根开始，检查当前节点中与键字符对应的链接。有两种情况：
//		1.存在链接。我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符。
//		2.不存在链接。若已无键字符，且当前结点标记为 isEnd，则返回 true。否则有两种可能，均返回 false :
//			a.还有键字符剩余，但无法跟随 Trie 树的键路径，找不到键。
//			b.没有键字符剩余，但当前结点没有标记为 isEnd。也就是说，待查找键只是Trie树中另一个键的前缀。
	// 时间复杂度：O(m)
	// 空间复杂度：O(1)
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char curLetter = word.charAt(i);
			if (node.containsKey(curLetter)) {
				node = node.get(curLetter);
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}

	// 查找键前缀
	// 时间复杂度：O(m)
	// 空间复杂度：O(1)
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

}
