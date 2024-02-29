# [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/description/)

![](https://img.shields.io/badge/Difficulty-Hard-red.svg)
![](https://img.shields.io/badge/Beats-99.63-green.svg)


Given a string containing just the characters `'('` and `')'`, return the length of the longest valid (well-formed) parentheses
substring.

<br>

**Example 1:**

    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".

**Example 2:**

    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".

**Example 3:**

    Input: s = ""
    Output: 0

<br>

**Constraints:**
- `0 <= s.length <= 3 * 104`
- `s[i]` is `'('`, or `')'`.