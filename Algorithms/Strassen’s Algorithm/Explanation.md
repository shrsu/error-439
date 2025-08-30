# Strassen’s algorithm

* Goal: multiply two $n \times n$ matrices faster than the naive $O(n^3)$.
* Trick: split each matrix into four $(n/2)\times(n/2)$ blocks and cleverly do **7** block multiplications instead of 8, plus some additions/subtractions.
* Recurrence: $T(n)=7T(n/2)+O(n^2)$ ⇒ time $O(n^{\log_2 7}) \approx O(n^{2.807})$.
* Practical bits:

  * Works best for **large** matrices; for small sizes, the classic multiply is often faster. Use a **cutoff** (e.g., 32–128) to switch to the naive algorithm.
  * Requires **square, power-of-two** sizes. In practice we **pad** to the next power of two and crop the result back.
  * Uses more memory because of extra temporary matrices.

# The seven products (for reference)

Let $A$ and $B$ be split into blocks:

$$
A=\begin{bmatrix}A_{11}&A_{12}\\A_{21}&A_{22}\end{bmatrix},\quad
B=\begin{bmatrix}B_{11}&B_{12}\\B_{21}&B_{22}\end{bmatrix}
$$

Compute:

* $M_1=(A_{11}+A_{22})(B_{11}+B_{22})$
* $M_2=(A_{21}+A_{22})B_{11}$
* $M_3=A_{11}(B_{12}-B_{22})$
* $M_4=A_{22}(B_{21}-B_{11})$
* $M_5=(A_{11}+A_{12})B_{22}$
* $M_6=(A_{21}-A_{11})(B_{11}+B_{12})$
* $M_7=(A_{12}-A_{22})(B_{21}+B_{22})$

Then assemble:

* $C_{11}=M_1+M_4-M_5+M_7$
* $C_{12}=M_3+M_5$
* $C_{21}=M_2+M_4$
* $C_{22}=M_1-M_2+M_3+M_6$

---
