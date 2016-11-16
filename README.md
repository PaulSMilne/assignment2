*JAVA PROJECT

**Sunday evening:

Have spent my time yesterday and today planning and drawing diagrams, and reading up on interfaces, enums and hashmaps.

Tonight started coding some simple getters and setters, using Sublime rather than Android. Glad I'm doing it with Sublime because it's helping me remember how everything fits together rather than let Android Studio do my thinking for me.

I'm using an Enum for the CardType, eg VISA_DEBIT("Visa Debit Card"). The Card gets initialised with a bank name and  card type. The Customer adds a "limit" which will do a calculation with spending and receiving refunds to work out how many funds are available. That's the theory anyway.

**Tuesday afternoon

Doing the default card was a multi step process. 

1. I had to change my BankCard class to take a boolean argument to flag the card as a default card, which initiates as false. 
2. Then I wrote a method to set that variable as true. 
3. Then I wrote a method to find the card in a hash of payment options that has the flag set to true, and return that card. 
4. This method is in the Transaction constructor and returns this.card for the class. 
5. In my test I newed up the customer and his/her payment options and cards first, then when I created the new transaction there were values for this method to work with. 
6. Then I overloaded the makeTransaction method to take two different strings of parameters. If it includes a card, the card is used in the transaction. If it doesn't include a card, it finds uses this.card in the class constructure which is the true card in the hashmap of payment methods.

**Wednesday morning

I'm revisitig the code I've done to see if I can move some of the heavy lifting from the Transaction class to the Customer class.

Created a refactor branch to investigate possible reworking of my code.

**Wednesday elevenses

Have refactored the code to move the card maths from the transaction page to the customer page. The transaction page now calls the customer method which makes payments (takes money away from) or receives refunds (adds money to) from/to a particular card. 

Then I further refactored to give the work of finding the current funds on a card to a separate customer method.

**Wednesday lunchtime

after having tinkered to my satisfaction with my MVP code I have proceeded to add an element of stock control as per the suggestion of the brief.

I have created a StockItem class and refactored the Shop class to include a hashmap of stock items. 

I wrote two new methods that tested out okay, to get the what is in the current stock hashmap, and to add items to the stock hashmap.