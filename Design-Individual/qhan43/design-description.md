1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

A MainMenuUI is implemented for this part. In addition, we create a Menu Class, a Job Class and a ComparisonSetting Class to fulfill the functions as shown in the UML diagram. When the app is started, a Menu Class is created. The currentJob attribute is used to store the current job’s information. The getter and setter functions in Job Class allows users to edit the currentJob. The function enterJobOffer(Job) add users enter new jobs. The List<Job> attribute is used to store the job offers users enter. The attribute comparisonSetting in Menu Class is to store comparison settings. The getter and setter methods in ComparisionSetting allow users to adjust the comparison settings. The compareJobOffers(Job, Job) function in Menu Class allows users to compare two jobs.



2. When choosing to enter current job details, a user will:

a. Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job.

A currentJobUI will be implemented to enter current job. This UI is not shown in the UML. The user interface consists of all entries for the attributes listed in Job Class. We will use function isCurrentJobExisted() to check if the current job is already entered or not. If the currentJob exists (if current job is already entered), getter methods of Job Class will be called to get all currentJob attributes to populate on such user interface for users to edit. If currentJob does not exists (if it is the first time to enter current job), the user interface entries will remain empty and wait for users to enter information for current job.

b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The save button and cancel button will be on currentJobUI which is not shown in the UML. If save button is click, the setter function of Job Class will be called to store all parameter in the currentJob attribute in Menu Class. If cancel button is click, we will not call setter function and directly discard all information. Then, a click handler in the user interface is called to return to the main menu.


3. When choosing to enter job offers, a user will:

a. Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.

This part is related to a user interface which is not shown in UML. The user interface will be similar to that shown in part 2a.


b. Be able to either save the job offer details or cancel.

The save button and cancel button will be on the user interface which is not shown in the UML. If save button is click, a Job Class instance will be created and the setter function of Job Class will be called to store all parameter in the Job Class instance. Then, this instance will be used as input for enterJobOffer(Job) function to store this job offer in the JobList attribute. If cancel button is click, we will not call setter function and directly discard all information. 


c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

If we want to enter another offer, another Job Class instance will be created, get all parameter from user interface by calling setters and finally save in JobList attribute by calling enterJobOffer(Job) function from Menu Class.  To return to main menu, we can implement a “return” button to call a click handler to return to the main menu UI. This part is not shown in UML. If we want to compare the offer with current job, we will call function isCurrentJobExisted() to check currentJob is entered or not. If currentJob exist, we will call compareJobOffers(Job, Job) to do the comparison.


4. When adjusting the comparison settings, the user can assign integer weights:

A ComparisonSettingUI will be implemented for this part. We have an attribute comparison in Menu Class which is used to store all the comparison settings. The setter and getter methods for ComparisonSetting Class allow users to set the weights they want. If they don’t set the weights, default value 1 will be used for the weight attributes. 


5. When choosing to compare job offers, a user will:

a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

We will implement a ListOfAllJobUI to show the job list (not shown in UML). When enter into this UI, the sortAllJob() function will be called to sort JobList with currentJob by using the jobScore attribute for ranking. Then, getAllJobs() function will be called to get all job offers from JobList and currentJob to populate on UI.


b. Select two jobs to compare and trigger the comparison.

We will implement a compareJobsUI. Select two jobs from the ListOfAllJobUI and pass as inputs for function compareJobs(Job, Job). A comparison button is implemented on ListOfAllJobUI (not shown in UML). When click this button, we go to compareJobsUI and call compareJobs(Job, Job) to do the comparison.

c. Be shown a table comparing the two jobs, displaying, for each job:

In compareJobsUI, a table will be used in this UI. Each table entry will display a parameter from Job Class. 

d. Be offered to perform another comparison or go back to the main menu.

Two buttons will be implemented on the compareJobsUI. One is to return to the ListOfAllJobUI and one is to return to main menu UI. To return to compareJobsUI, we can perform another comparison. 


6. When ranking jobs, a job’s score is computed as the weighted sum of … :

To fulfill this, a jobScore attribute in Job Class is used. We will call the calculateJobScore() function to calculate the job score for ranking by using the function provided from the requirement. 

