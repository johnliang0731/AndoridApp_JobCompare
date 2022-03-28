1. When the app is started, the user is presented with the main menu, which allows the user to 
(1) enter or edit current job details, 
(2) enter job offers, 
(3) adjust the comparison settings, or 
(4) compare job offers (disabled if no job offers were entered yet).
```
These views are not directly shown in the design and will be handled in the GUI 
layer of the application. All these operations, however, will trigger methods in 
the SystemController class
(1) -> setCurrentJob() (getters/setters were omitted from the diagram)
(2) -> addJobOffer()
(3) -> editComparisonSettings()
(4) -> compareJobOffers()

SystemController can be thought of as the entrypoint to the system and contains
handler methods for actions that can be taken in the UI
```  

2. When choosing to enter current job details, a user will:
   * Be shown a user interface to enter (if it is the first time) or edit all of the details of their current job, which consist of:
     * Title
     * Company
     * Location (entered as city and state)
     * Cost of living in the location (expressed as an index)
     * Yearly salary
     * Yearly bonus
     * Allowed weekly telework days (expressed as the number of days per week allowed for remote work, inclusively between 0 and 5)
     * Retirement benefits (as percentage matched)
     * Leave time (vacation days and holiday and/or sick leave, as a single overall number of days)
   * Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
```
This information is captured in the Job entity in the design. The different actions such
as saving job details, cancelling or exiting without saving can be handled with buttons in
the GUI and are not directly shown in this design
```

3. When choosing to enter job offers, a user will:
   * Be shown a user interface to enter all of the details of the offer, which are the same ones listed above for the current job.
   * Be able to either save the job offer details or cancel.
   * Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).
 ```
This is not directly represented in the design. These are flows that need to be managed in the GUI i.e navigation, saving/cancelling,
forms for entering job details
```

4. When adjusting the comparison settings, the user can assign integer weights to:
   * Yearly salary
   * Yearly bonus
   * Allowed weekly telework days
   * Retirement benefits
   * Leave time
```
This information will be stored in the ComparisonSettings entity. This will be a single entity that
will exist throughout the life of the application. The entrypoint into our system i.e.
SystemController will allow for modifications to this entity
```

5. When choosing to compare job offers, a user will:
   * Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
   * Select two jobs to compare and trigger the comparison.
   * Be shown a table comparing the two jobs, displaying, for each job:
       * Title
       * Company
       * Location
       * Yearly salary adjusted for cost of living
       * Yearly bonus adjusted for cost of living
       * Allowed weekly telework days
       * Retirement benefits (as percentage matched)
       * Leave time
   * Be offered to perform another comparison or go back to the main menu.
```
Being able to see a list of job offers ordered from best to worst will be handled
by the SystemController class. The showTopJobOffers() method will be responsible
for returning a list of ordered Job objects for the GUI to render.

Similarly triggering a comparison of two jobs will also be handled by the SystemController
class in the compareJobOffers() method which will be responsible for rendering the
GUI in the layout mentioned above

Navigation back to the main menu or performing another comparison will be handled via
buttons in the Android app which will render different layouts

```

6. When ranking jobs, a job’s score is computed as the weighted sum of:

   AYS + AYB + (RBP * AYS) + (LT * AYS / 260) - ((260 - 52 * RWT) * (AYS / 260) / 8)

    where:
    
    AYS = yearly salary adjusted for cost of living
    
    AYB = yearly bonus adjusted for cost of living
    
    RBP = retirement benefits percentage
    
    LT = leave time
    
    RWT = telework days per week

```
This is not represented directly in my design as this will be an implementation
detail used to order the list of job offers shown to the user of the 
application
```

7. The user interface must be intuitive and responsive.
```
This is not represented in my design and will be handled within Android's layout
manager framework implementation (GUI)
```

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
```
To realize this requirement I created a singleton class called SystemController. 
There will be one instance of this class and it will manage all of the application's 
state internally. This will be the entrypoint to the system and will be the
main interaction point for the GUI to hook into.
```



