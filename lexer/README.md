# COOL Compiler #
 By reading line by line from a file 
 for each line making escape characters such as \n etc as a single character other than making \ and n as two different characters
  from line 79 to 114;
  
Each Token rule is given as DFA
for ERROR token string containing null character, invalid character,unterminated string constant
for single characters like semicolon etc we gave the DFA directly as for semicolon ';' and DARROW '=>' etc

for tokens like OBJECT_ID DFA given as a string starting with small letter and consits of letter and underscores
similarly for TYPE_ID it is starting with capital letter

string constant the string between double quotes(") if a escape character is fount in between string constant extended till it finds (")

Int_constant containing 1 or more digits

Bool_constant true or false the are case insensitive and hence true tRue can be recognized first letter is small

all the keywords of cool such as case, if, else etc are case insensitives and constructed the DFA so that the token can be recognized ex:IN          : ('i'|'I')('n'|'N');

finally we need to ignore the comments and white spaces skip is use to ignore them

comment should not be passed as token and hence these are not written under ERROR token mentioned above as it is not passes to the parser
errors like unmatched *) etc are directly reported without tokenizing


why this code works?
 we defned all the cool keywords and also we defined all possible cases to that can be entered from the computer's keyboard
