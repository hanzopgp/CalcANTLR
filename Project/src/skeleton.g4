calcul returns [ String code ]
@init{ $code = new String(); }   // On initialise code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

instruction returns [ String code ] 
    : expression finInstruction 
        { 
            String instr = $expression.code.split(" ")[0];
            switch(instr){
                case "PUSHI" :
                    $code += "stack.push($expression.code.split(" ")[1]);"
                    break;
                case "ADD" :
                    $code += "int tmp = stack.pop() + stack.pop();"
                    break;
                case "SUB" :
                    $code += "int tmp = - stack.pop() + stack.pop();"
                    break;
                case "MUL" :
                    $code += "int tmp = stack.pop() * stack.pop();"
                    break;
                case "DIV" :
                    $code += "int tmp = ( 1 / stack.pop()) * stack.pop();"
                    break;
                case "INF" :
                    $code += "boolean tmp = stack.pop() > stack.pop();"
                    break;
                case "INFEQ" :
                    $code += "boolean tmp = stack.pop() >= stack.pop();"
                    break;
                case "SUP" :
                    "boolean tmp = stack.pop() < stack.pop();"
                    break;
                case "SUPEQ" :
                    "boolean tmp = stack.pop() <= stack.pop();"
                    break;
                case "EQUAL" :
                    "boolean tmp = stack.pop() == stack.pop();"
                    break;
                case "NEQ" :
                    "boolean tmp = stack.pop() != stack.pop();"
                    break;
            }
        }
   | finInstruction
        {
            $code="";
        }
    ;

expression returns [ String code ]
    : 
      PUSHI ENTIER
    | ADD ENTIER ENTIER
    | SUB ENTIER ENTIER
    | MUL ENTIER ENTIER
    | DIV ENTIER ENTIER
    | INF ENTIER ENTIER
    | INFEQ ENTIER ENTIER
    | SUP ENTIER ENTIER
    | SUPEQ ENTIER ENTIER
    | EQUAL ENTIER ENTIER
    | NEQ ENTIER ENTIER
    ;

finInstruction : ( NEWLINE | ';' )+ ;