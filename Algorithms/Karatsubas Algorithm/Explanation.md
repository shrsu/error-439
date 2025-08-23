**Karatsuba’s Algorithm** is a fast multiplication algorithm for large numbers, discovered by **Anatoly Karatsuba** in 1960.

---

### The Problem

Normally, multiplying two $n$-digit numbers takes about $O(n^2)$ operations (the standard grade-school method).
Karatsuba found a way to reduce this to about $O(n^{\log_2 3}) \approx O(n^{1.585})$, which is much faster for big numbers.

---

### The Idea

Suppose we want to multiply two numbers $x$ and $y$, each with $n$ digits.
We split them into two halves:

$$
x = x_1 \cdot 10^m + x_0
$$

$$
y = y_1 \cdot 10^m + y_0
$$

where:

* $m$ is about half of $n$,
* $x_1, y_1$ = higher half,
* $x_0, y_0$ = lower half.

So:

$$
x \cdot y = (x_1 \cdot 10^m + x_0)(y_1 \cdot 10^m + y_0)
$$

Expanding:

$$
x \cdot y = z_2 \cdot 10^{2m} + z_1 \cdot 10^m + z_0
$$

where:

* $z_2 = x_1 y_1$
* $z_0 = x_0 y_0$
* $z_1 = x_1 y_0 + x_0 y_1$

---

### The Trick

Naively, to compute $z_1$, we need **two multiplications** ($x_1y_0$ and $x_0y_1$).
But Karatsuba noticed a shortcut:

$$
z_1 = (x_1 + x_0)(y_1 + y_0) - z_2 - z_0
$$

This means:

* Instead of **4 multiplications**, we only need **3 multiplications**:

  * $z_2 = x_1 y_1$
  * $z_0 = x_0 y_0$
  * $z_3 = (x_1 + x_0)(y_1 + y_0)$

And then:

$$
z_1 = z_3 - z_2 - z_0
$$

Thus, only **3 recursive multiplications** are required instead of 4.

---

### Example

Let’s multiply $1234 \times 5678$.

Split into halves ($m = 2$):

* $x_1 = 12, \; x_0 = 34$
* $y_1 = 56, \; y_0 = 78$

Compute:

* $z_2 = 12 \times 56 = 672$
* $z_0 = 34 \times 78 = 2652$
* $z_3 = (12+34)(56+78) = 46 \times 134 = 6164$
* $z_1 = z_3 - z_2 - z_0 = 6164 - 672 - 2652 = 2840$

Final result:

$$
1234 \times 5678 = 672 \cdot 10^{4} + 2840 \cdot 10^{2} + 2652
= 7006652
$$

Which is correct.

---

### Complexity

* Standard multiplication: $O(n^2)$
* Karatsuba: $O(n^{\log_2 3}) \approx O(n^{1.585})$

For **very large numbers**, this is much faster.

---

## Explanation of the Code

1. **Base Case**
   If either $x$ or $y$ is a single-digit number (`< 10`), just multiply directly.

2. **Split the Numbers**

   * Suppose we multiply `1234 * 5678`.
   * We split each into two halves:

     * `x = 12 | 34`
     * `y = 56 | 78`

   This is done using division (`/`) and modulus (`%`) with `10^m`.

3. **Recursive Calls**

   * `z0 = karatsuba(low1, low2)` → multiply lower halves.
   * `z2 = karatsuba(high1, high2)` → multiply higher halves.
   * `z1 = karatsuba((high1 + low1), (high2 + low2)) - z2 - z0`
     → cross multiplication using Karatsuba’s trick.

4. **Combine the Results**

   * Multiply `z2` by `10^(2m)` (shift left by 2\*m digits).
   * Multiply `z1` by `10^m`.
   * Add `z0`.
     This reconstructs the full result.

---

### Example Run

For `x = 1234`, `y = 5678`:

* Split into:

  * `high1=12, low1=34`
  * `high2=56, low2=78`

* Compute:

  * `z2 = 12 * 56 = 672`
  * `z0 = 34 * 78 = 2652`
  * `z1 = (12+34)(56+78) - 672 - 2652 = 2840`

* Combine:

  $$
  result = 672 \cdot 10^4 + 2840 \cdot 10^2 + 2652 = 7006652
  $$

Which is correct.
