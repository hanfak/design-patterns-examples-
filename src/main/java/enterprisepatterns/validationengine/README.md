validation Engine

Examples:
- collection 
- map
- optional
- primitive 

Library 
- create list of rules using builder (for each case different builder)
    - Pairs(predicate, exception)
    - Pairs(predicate, message)
    - builder stores different pairs in to different lists
    - Common factories, that build up set rules for different inputs, and used can add their own rules
- Static method takes in rules builder and input, returns input if all validations passes, or exception if at least one
 validation rule fails
- Common rules to use
    - non null
    - non blank
    
Api 

RulesBuilder builder = RulesBuilder
                        .add(Pair.of(x -> x.contians("3"), () -> new IllegalExceptin))
                        .add(Pair.of(x -> x.contians("a"), () -> new IllegalExceptin))
                        .add(Pair.of(x -> x.contians("a"), Exception message)
                        .add(Pair.of(x -> x.contians("a").and(x -> x.contians("z")), x -> new IllegalExceptin)
RulesBuilder builder = stringValidationrules() // static
                        .add(Pair.of(x -> x.contians("3"), () -> new IllegalExceptin))
RulesBuilder builder = listValidationrules() // static
                        .add(Pair.of(x -> x.size < 7, () -> new IllegalExceptin))     
runners:                        
T input = ValidationRules.validate(builder, input); // static method
// new up, so can be injected, ValidationRules is interface
ValidationRules validationRules = new ValidationRules(builder);  
T input = validationRules.validate(input) // calling it
                                                           
