# dynamicOptimalStopping
Optimal Stopping problem solved using a dynamic programming approach.

Introduction:

From https://en.wikipedia.org/wiki/Secretary_problem

The secretary problem demonstrates a scenario involving optimal stopping theory
that is studied extensively in the fields of applied probability, statistics, and
decision theory. It is also known as the marriage problem, the sultan's dowry
problem, the fussy suitor problem, the googol game, and the best choice problem.

The basic form of the problem is the following: imagine an administrator who wants
to hire the best secretary out of n rankable applicants for a position. The 
applicants are interviewed one by one in random order. A decision about each particular
applicant is to be made immediately after the interview. Once rejected, an applicant 
cannot be recalled. During the interview, the administrator gains information sufficient
to rank the applicant among all applicants interviewed so far, but is unaware of the 
quality of yet unseen applicants. The question is about the optimal strategy 
(stopping rule) to maximize the probability of selecting the best applicant.
If the decision can be deferred to the end, this can be solved by the simple maximum
selection algorithm of tracking the running maximum (and who achieved it),
and selecting the overall maximum at the end. 

The difficulty is that the decision must be made immediately.

My Solution:

A sample size is used to find the best way to pick the immediate candidate. The problem 
is finding the best sample size. In my solution, I elected to set the sample size to when
the probability of a better candidate appearing is surpassed by something called a "keep-going
-metric"(KGM). This KGM is calculated by adding the sequences of prbability found in previous steps.
To avoid large runtimes, I use memoization in an array and store these proabilities.
