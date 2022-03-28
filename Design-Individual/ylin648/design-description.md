This is a **job offers comparison** app

1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

*Description:*
To realize this, I created a class called *system*, which links to *jobs class* and *weights class*; it has two attributes and five methods.
* attribute *job: list* is a list for saving all jobs' titles, so that we can refer them in the future just in case.
* attribute *noJob: int* is an integer to calculate the number of jobs on the platform and it will be start from 0 and adding 1 the first time adding a current job with a *saveJob* method or adding all non-current jobs' with *saveJob* methods; it will be the same with the length of the attribute *job list*.
* method *saveJob()* is to accomplish (1) - enter or edit current job details and accomplish (2) - add new job offers; it will connect with class *jobs* to set and get its attributes, after prompts are handled within the GUI.
* method *cancelandReturn()* is to return without saving anything and back to the main manual, after prompts are handled within the GUI. All cancel/exti or return below are handled by it as well.
* method *saveWeight()* is to accomplish (3) - adjust the weights settings and it connects with class *weights* to set and get its attributes, after prompts are handled within the GUI, after prompts are handled within the GUI.
* method *updateAllRanking* will be implemented after method *saveWeight* and at the beginning of method *compare()*; it will include a *for loop* to calculate the scores for all jobs in *class job*, sort the scores and assign the ranking of scores to attribute *ranking* by using method *setRanking()* in class *jobs*.
* method *compare()* is to accomplish (4) - compare two job offers or one offer with the current job; it links to class *jobs* and compare and sort two job classes based on their attribute *score*, after prompts are handled within the GUI. But it has a requirement that attribute *noJob* should be greater than 2.


2. When choosing to enter current job details, a user will: Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of: Title, Company, Location (entered as city and state), Cost of living in the location (expressed as an index), Yearly salary, Yearly bonus, Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5), Retirement benefits (as percentage matched), Leave time (vacation days and holiday and/or sick leave, as a single overall number of days), Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

*Description:*
To realize this, I created a class called *jobs*, which includes attributes of
* *title: string* for job title
* *co: string* for company name
* *loc: string* for location dropdown list (including city and state)
* *cost: int* for cost of living pricing
* *ays: int* for yearly salary
* *ayb: int* for yearly bonus
* *rwt: int* for allowed weekly telework days ranging from 0 to 5
* *pbp: int* for retirement benefits and divide 100 as percentage matched
* *lt: int* for leave time
* *ranking: float* for ranking

Other methods and subclass of this class includes:
* method *updateScore()* for updating the scores for each job by using the weights from class *weight* and attributes from class *jobs*
* subclass *currentJob* will have an attribute of *current: boolean = true*
* subclass *jobOffer* doesn't have new attributes

The enter/edit process will be handled by methods *set/get...()* in this class

The attribute *cost* will be set by using method *getValue()* from class *costDict* that has two attributes (attribute *key* will be the combination of city and state while attribute *value* will be the cost index); since it's a percentage, the value need to divide 100.

Save and cancel will be handled by methods *saveJob()* and *cancelandReturn()* in class *system*, which have been mentioned in bullet 1.

3. When choosing to enter job offers, a user will:
Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
Be able to either save the job offer details or cancel.
Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

*Description:*
To realize and simplify this, I consolidate this with enter/edit current job. So the process will be the same as above. Save and cancel will be handled by methods *saveJob()* and *cancelandReturn()* in class *system*, which have been mentioned in bullet 1. Comparing offers will be handled by method *compare()* in class *system*.

4. When adjusting the comparison settings, the user can assign integer weights to:
*Yearly salary
*Yearly bonus
*Allowed weekly telework days
*Retirement benefits
*Leave time
If no weights are assigned, all factors are considered equal.

*Description:*
To realize this, I created a class *weights*, which includes five attributes:
* *aysW: int* for yearly salary
* *aybW: int* for yearly bonus
* *rwtW: int* for allowed telework days
* *pbpW: int* for retirement benefits
* *ltW: int* for leave time
The range of them will be [1,5]. The default will be 1 for them.
The enter/edit process will be handled by methods *set/get...()* in this class and they will be triggered by method *saveWeight()* in class *system*, which has been mentioned in bullet 1.

5. When choosing to compare job offers, a user will:
Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
Select two jobs to compare and trigger the comparison.
Be shown a table comparing the two jobs, displaying, for each job:
Title
Company
Location
Yearly salary adjusted for cost of living
Yearly bonus adjusted for cost of living
Allowed weekly telework days
Retirement benefits (as percentage matched)
Leave time
Be offered to perform another comparison or go back to the main menu.

*Description:*
To realize this, we've created the method *compare()* in class *system*, the whole process has been mentioned in bullet 1.


6. When ranking jobs, a job’s score is computed as the weighted sum of:

AYS + AYB + (RBP * AYS) + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
RBP = retirement benefits percentage
LT = leave time
RWT = telework days per week
The rationale for the RWT subformula is:
value of an employee hour = (AYS / 260) / 8
commute hours per year (assuming a 1-hour/day commute) =
1 * (260 - 52 * RWT)
therefore travel-time cost = (260 - 52 * RWT) * (AYS / 260) / 8

For example, if the weights are 2 for the yearly salary, 2 for the retirement benefits, and 1 for all other factors, the score would be computed as:

2/7 * AYS + 1/7 * AYB + 2/7 * (RBP * AYS) + 1/7 * (LT * AYS / 260) - 1/7 * ((260 - 52 * RWT) * (AYS / 260) / 8)

*Description:*
Method *updateScore()* in class *jobs* will realize this for each class *jobs*, and it will be calculated by using the weights from class *weight* and attributes from class *jobs*.

7. The user interface must be intuitive and responsive.
8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

*Description:*
I believe it's simple and straightforward. Requirement 7 and 8 will be accomplished.
