# *nCal* ~ My Personal Project

## A minimalist calendar program.

**nCal** is a simple and easy to use calendar program inspired by the
several calendar applications that allow millions of people to navigate their days in an
organized manner. Like those applications, nCal will have an easy to use interface that will
present users with a full calendar in which they can enter events, reminders, and daily to-do lists.
Furthermore, users will be able to set alarms or alerts for when they wanted to be reminded about their entries.
In short, the goal of this program is to provide the end user with the absolute necessities needed for a calendar program,
without the added bloatware and confusion that is present on other calendar software. In short, the goal of **nCal** is to be a
minimalist calendar.

The target end users for **nCal** are those who only needs the basics from a calendar software; without any of the extra features
or confusing interfaces that are only used by advanced users. If someone needs to keep track of the events coming up in their life in the simplest way, **nCal** is for them!

*Developer Note: My interest in this project came from my experience with several calendar applications I have used that had too much going on
for a user like me that only needed to use the most necessary features.* 
 
 
## User Stories
The following are "User stories" that describe how someone can use **nCal** to produce a specific outcome
- "*As a user, I want to be able to add multiple events to my calendar.*"
- "*As a user, I want to be able to add multiple reminders to my calendar.*"
- "*As a user, I want to be able to add multiple todo-list tasks to my calendar.*"
- "*As a user, I want to be able to view the calendar and see my entries.*"
- "*As a user, I want to be able to delete an entry from the calendar*"
- "*As a user, I want to be able to save my calendar and view it later*"
- "*As a user, I want to be able to load a previously saved calendar*"

## Phase 4: Task 2
For this task, I chose to make the Date class robust. Originally, the constructor of the Date
class which has an *int day* parameter passed through it had the following requires clause: 
*REQUIRES: 1 <= day <= Maximum Days in given month*. The constructor in the Date class was the only method in the
class with a requires clause. To make the constructor robust, I implemented a checked exception called *InvalidDayException*,
which was thrown by the constructor of the date class if the conditions of the original requires clause was not met. With the exception being
fully tested and implemented, the requires clause was removed and the effects clause was updated to:*EFFECTS: If (1 <= day <= Maximum Days) is not true, throw InvalidDayException.
Otherwise, construct a day with a month, day, and empty lists for user entries.* Thus, the Date class is now robust!

