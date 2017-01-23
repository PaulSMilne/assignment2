#JAVA PROJECT

##Initial Brief

###Shop

**Goal:** Practice OO modelling in Java (unit tests, no UI)

You are required to build an app that allows a Shop to sell goods to a Customer. Stock and items are not important.

##MVP

The Shop must be able to:

Make a Sale: The customer funds go down, shop sales amt goes up
Give a refund: The customer funds go up, shop refunds amt go up
Report on income: Total sales minus total refunds

The Customer must:

Have a collection of possible Payment Methods: CreditCard (default), DebitCard
Be able to select a Payment Method to pay at any Shop
Be able to select a Payment Method to recieve a refund onto a given Payment Method

##Project Extensions

Add stock tracking

##Prioritise Requirements

* Customers
 * Have a total amount to spend, split between debit and credit limits
 * Have collection of payment methods, credit and/or debit, one of which can be designated as default
 * Can select payment method for a sale 
 * Can select payment method to receive a refund from a shop

* Shop
 * Make a Sale
 * Make a refund
 * Have a sales amount
 * Have a refund amount
 * Have a total income amount

* Extra functionality
 * Add stock control
   * items to sell
   * quantity of each item in stock
   * stock decreases with sales, can also add stock

##Diary

###Sunday evening:

Have spent my time yesterday and today planning and drawing diagrams, and reading up on interfaces, enums and hashmaps.

Tonight started coding some simple getters and setters, using Sublime rather than Android. Glad I'm doing it with Sublime because it's helping me remember how everything fits together rather than let Android Studio do my thinking for me.

I'm using an Enum for the CardType, eg VISA_DEBIT("Visa Debit Card"). The Card gets initialised with a bank name and  card type. The Customer adds a "limit" which will do a calculation with spending and receiving refunds to work out how many funds are available. That's the theory anyway.

###Tuesday afternoon

Doing the default card was a multi step process. 

1. I had to change my BankCard class to take a boolean argument to flag the card as a default card, which initiates as false. 
2. Then I wrote a method to set that variable as true. 
3. Then I wrote a method to find the card in a hash of payment options that has the flag set to true, and return that card. 
4. This method is in the Transaction constructor and returns this.card for the class. 
5. In my test I newed up the customer and his/her payment options and cards first, then when I created the new transaction there were values for this method to work with. 
6. Then I overloaded the makeTransaction method to take two different strings of parameters. If it includes a card, the card is used in the transaction. If it doesn't include a card, it finds uses this.card in the class constructure which is the true card in the hashmap of payment methods.

###Wednesday morning

I'm revisiting the code I've done to see if I can move some of the heavy lifting from the Transaction class to the Customer class.

Created a refactor branch to investigate possible reworking of my code.

###Wednesday elevenses

Have refactored the code to move the card maths from the transaction page to the customer page. The transaction page now calls the customer method which makes payments (takes money away from) or receives refunds (adds money to) from/to a particular card. 

Then I further refactored to give the work of finding the current funds on a card to a separate customer method.

###Wednesday lunchtime

after having tinkered to my satisfaction with my MVP code I have proceeded to add an element of stock control as per the suggestion of the brief.

I have created a StockItem class and refactored the Shop class to include a hashmap of stock items. 

I wrote two new methods that tested out okay, to get the what is in the current stock hashmap, and to add items to the stock hashmap.

**Next Sunday (20 Nov)

I got into a real guddle last week with my git commits so this readme looks to be not right up to date. Anyway, after doing the stock thread and turning that in as my final homework, on Friday I worked on creating a "Payable" interface so I could designate emoney payments as well as cards. 

Now I'm looking to create a separate Debit Card and Credit Card classes that do different things as far as their available funds are concerned. The credit card will continue to be as normal, but the debit card and emoney will instead get their values from a new bank account instance variable.

I've created a new git branch to do this work on.
