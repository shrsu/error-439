## Approach

1. **Sort Jobs by Profit**
    - Arrange all jobs in **descending order of profit**.
    - This ensures we always try to pick the most profitable job first.
2. **Find Maximum Deadline**
    - Identify the largest deadline among all jobs.
    - This will define the maximum number of time slots needed.
3. **Initialize Schedule**
    - Create an array of size `maxDeadline` to represent available time slots.
    - Initially, all slots are empty.
4. **Assign Jobs to Slots**
    - Iterate over jobs (in sorted profit order).
    - Try to place each job in the **latest free slot before or on its deadline**.
    - If a free slot exists, schedule the job and add its profit.
    - Otherwise, skip it.
5. **Return Total Profit + Scheduled Jobs**

---