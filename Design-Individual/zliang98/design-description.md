1.	When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet ).  

*To realize requirement (1), I added method enterJob() to Job class to enter a new job, and editJob() to edit job detail; Requirement (2) can also be achieved by method enterJob(); to achieve requirement (3), I added method assignWeight() to class Comparison to edit comparison settings; to achieve requirement (4), I added method compareJobs() to class Comparison to compare job offers.*

----------

2.	When choosing to enter current job details, a user will:
a.	Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
i.	Title
ii.	Company
iii.	Location (entered as city and state)
iv.	Cost of living in the location (expressed as an index)
v.	Yearly salary
vi.	Yearly bonus
vii.	Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)
viii.	Retirement benefits (as percentage matched)
ix.	Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)
b.	Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

*To realize requirement a, I created Job class and added followed attribtes: title, company, location, costOfLiving, yearlySalary, yearlyBonus, weeklyTeleworkDays, retirementBenefit, leaveTime. And the CitiState is a utility with two attributes: city, state. livingCost is a utility with two attributes: location, cost.
Requirement b will be realized by method editJob in Job class. And the cancel/exit function will be handled entirely by GUI implementation.*

----------

3.	When choosing to enter job offers, a user will:
a.	Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
b.	Be able to either save the job offer details or cancel.
c.	Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer with the current job details (if present).

*These three requirements are not represented in my design. They could be handled by GUI of the APP.*

----------

4.	When adjusting the comparison settings, the user can assign integer weights to:
a.	Yearly salary
b.	Yearly bonus
c.	Allowed weekly telework days
d.	Retirement benefits
e.	Leave time
If no weights are assigned, all factors are considered equal.

*To realize this requirement, I created the class Comparison with five attributes: yearlySalaryWeight, yearlyBonusWeight, weeklyTeleworkDaysWeight, retirementBenefitWeight, leaveTimeWeight. And all of these attributes default value is 1.*

----------

5.	When choosing to compare job offers, a user will:
a.	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
b.	Select two jobs to compare and trigger the comparison.
c.	Be shown a table comparing the two jobs, displaying, for each job:
i.	Title
ii.	Company
iii.	Location
iv.	Yearly salary adjusted for cost of living
v.	Yearly bonus adjusted for cost of living
vi.	Allowed weekly telework days
vii.	Retirement benefits (as percentage matched)
viii.	Leave time
d.	Be offered to perform another comparison or go back to the main menu.

*The requirement a will be achieved by the method displayRankJobList() and GUI of the APP
The requirement b is achieved by the method of compareJobs(), and the relationship between Job and Comparison with multiplicities 2 on Job class and 0..\* on Comparison class
The requirement c and d will be achieved by GUI of the APP.*

----------

6.	When ranking jobs, a job’s score is computed as the weighted sum of:

AYS + AYB + (RBP * AYS) + (LT * AYS / 260) + ((260 - 52 * RWT) * (AYS / 260) / 8)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RBP = retirement benefits percentage
LT = leave time
RWT = telework days per week
The rationale for the RWT subformula is:
a.	value of an employee hour = (AYS / 260) / 8
b.	commute hours per year (assuming a 1-hour/day commute) =
1 * (260 - 52 * RWT)
c.	therefore travel-time value = (260 - 52 * RWT) * (AYS / 260) / 8

For example, if the weights are 2 for the yearly salary, 2 for the retirement benefits, and 1 for all other factors, the score would be computed as:

2/7 * AYS + 1/7 * AYB + 2/7 * (RBP * AYS) + 1/7 * (LT * AYS / 260) + 1/7 * ((260 - 52 * RWT) * (AYS / 260) / 8)


*To realize this requirement, I added the method calculateJobScore on Job class. This method would calculate the rank score of the job as required function.*

----------

7.	The user interface must be intuitive and responsive.

*This requirement could be realized by GUI implementation of the APP.*

----------

8.	For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

*This requirement will be realized by the process of constructing the app.* 
