import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;

public class UtilsInJava {
    public static void testProlog(){
          try {
              Prolog engine = new Prolog();
              SolveInfo sol1 = engine.solve("consult('./unibolibs/sysRules.pl').");
              System.out.println("UtilsInJava | testProlog sol1= " + sol1 );
              SolveInfo sol2 = engine.solve("consult('demo0.pl').");  //tuprolog works on unibolibs
              System.out.println("UtilsInJava | testProlog sol2= " + sol2 );
              engine.solve("showSystemConfiguration.");
         }catch(Exception e){
             System.out.println("UtilsInJava | testProlog ERROR " + e.getMessage());
         }

    }
}
