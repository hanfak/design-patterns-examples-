Here the issue with DRY, is one class needs changes which will affect the other classes usage of this shared code

Due to the foresight of using an interface on this shared code, we can at run time use the correct dependency

Can use decorator pattern, ABCD all have same logic underneath, but A needs a bit more logic added to it
    - This will not work if the logic is completely different, so inlining might be best or inject a separate dependency
    - The power of the decorator allows the sharing of the code, but also configuring  wihtout changing the consuming class