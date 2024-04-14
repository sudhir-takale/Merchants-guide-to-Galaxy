## Merchant's Guide to the Galaxy
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with
0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford
to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which
apparently is worth a lot).<br>
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a
program to help you.<br>
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you
have painstakingly collected the appropriate translation between them.
Roman numerals are based on seven symbols<br>

- The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They
may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.)
"D", "L", and "V" can never be repeated.<br>
- "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can
be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.<br>
- Only one small-value symbol may be subtracted from any large-value symbol.<br>
- A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is
composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be
treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 =
MCMIII.<br>
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
- Input to your program consists of lines of text detailing your notes on the conversion between intergalactic
units and roman numerals.<br>
- You are expected to handle invalid queries appropriately.<br><br>

### Test input:
glob is I <br>
prok is V<br>
pish is X<br>
tegj is L<br>
glob glob Silver is 34 Credits<br>
glob prok Gold is 57800 Credits<br>
pish pish Iron is 3910 Credits<br>
how much is pish tegj glob glob ?<br>
how many Credits is glob prok Silver ?<br>
how many Credits is glob prok Gold ?<br>
how many Credits is glob prok Iron ?<br>
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?<br>

### Test Output:
pish tegj glob glob is 42<br>
glob prok Silver is 68 Credits<br>
glob prok Gold is 57800 Credits<br>
glob prok Iron is 782 Credits<br>
I have no idea what you are talking about<br>

------------------------------------------------------------------------
Solution:


- Domain 
    - Model 
      - GalacticTransactions 
            - id
            - transaction 
            - Metal
            - Credits
      - RomanTranslation(enum)
    
    - Service
      - processTransactions
        <br>
        <br>
- co
- nfiguration
  - numerals 
  - transactions
<br>
<br>
- Controllers
    - FileProcessingController
        - processInputFile
    - GalacticController
        - processTransactions 
        - showTransactions
          <br>
          <br>
- Services
    - FileProcessingService
    - GalacticService
          - crateTransaction
          - ProcessTransaction
          - getTransactions
      <br>
      <br>
- Repository
    - FileRepository
        - GalacticTransactionDTO
    - GalacticTransactionRepository
        - AddTransaction
        - fetchTransaction
         