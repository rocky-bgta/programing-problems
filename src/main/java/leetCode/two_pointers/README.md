# TWO POINTERS

## When to use this approach
Maintain two indices, move them according to an invariant, and avoid extra arrays when possible.

## How to approach problems
For each problem: (1) restate input/output and constraints; (2) work through a small example; (3) identify the invariant or data structure; (4) dry-run boundary cases; (5) derive time and space complexity; (6) compare the existing Java solution. The order below is a learning recommendation, not a claim that the existing implementations are optimal.

## Recommended solving order
1. **ReverseString** — [Java solution](ReverseString.java). Start here to learn the core idea.
2. **ValidPalindrome_125** — [Java solution](ValidPalindrome_125.java). Build on the previous problem; explain what new constraint or technique is introduced.
3. **RemoveDuplicates_26** — [Java solution](RemoveDuplicates_26.java). Build on the previous problem; explain what new constraint or technique is introduced.
4. **MoveZeroes_283** — [Java solution](MoveZeroes_283.java). Build on the previous problem; explain what new constraint or technique is introduced.
5. **MergeSortedArray_88** — [Java solution](MergeSortedArray_88.java). Build on the previous problem; explain what new constraint or technique is introduced.
6. **ValidPalindrome_II_680** — [Java solution](ValidPalindrome_II_680.java). Build on the previous problem; explain what new constraint or technique is introduced.

## Why this order?
Start with a smaller state space, then add boundary cases, extra constraints, or combinations of techniques. Before each next problem, articulate what changes compared with the previous one. Verify the actual implementation and complexity; do not assume the filename alone proves a technique.
