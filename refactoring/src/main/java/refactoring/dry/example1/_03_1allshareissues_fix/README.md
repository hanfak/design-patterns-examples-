Here the issue with DRY, is one class needs changes which will affect the other classes usage of this shared code

Due to the foresight of using an interface on this shared code, we can at run time use the correct dependency

A fix would be to inline the extracted logic back into A, and let BCD continues use the shared code 
    - What happens when B C or D want to use the same code as A? Will they inline too
A fix would be to extracted logic to separate class and inject into A, and let BCD continues to use the shared code 
    - Now if B C or D want to use the same logic as A it can do