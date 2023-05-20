Given a table showing amount of units of a product sold at the shop and the corresponding price per unit.

```html
purchase quantity                                  price per unit
    1-5                                              5 dollars
    6-10                                             4 dollars
    11-20                                            3 dollars
    20+                                              2.5 dollars
```

write out a function that takes the amount of the times being purchased as the input and output the price per unit according the table. So if the input is 5, the function returns 5, and if the input is 6, the function returns 4.

TODO 

- Can allow consumers of api to pass in data set (is constructor/arg)
  - need to be defensive that data is provided correctly
- use config file to store rules data, thus non devs can alter it
  - cause issues down the line (so need lots of checks)
- guard clause for quick exist