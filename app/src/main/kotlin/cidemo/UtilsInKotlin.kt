package cidemo

import alice.tuprolog.Prolog
import alice.tuprolog.Struct

object UtilsInKotlin {
    val engine = Prolog()

    fun loadRules() {
        try {
            val sol1 = engine.solve("consult('../unibolibs/sysRules.pl').")
            println("UtilsInKotlin | testProlog sol1= $sol1")
            val sol2 = engine.solve("consult('demo0.pl').") //tuprolog works on unibolibs
            println("UtilsInKotlin | testProlog sol2= $sol2")
        } catch (e: Exception) {
            println("UtilsInKotlin | testProlog ERROR " + e.message)
        }        
    }
    
    fun showSystemConfiguration() {
        try {
              engine.solve("showSystemConfiguration.")
        } catch (e: Exception) {
            println("UtilsInKotlin | testProlog ERROR " + e.message)
        }
    }
    
    fun getActorNumber() : Int{
        val solveInfo = engine.solve("getTheActors(ACTORLIST).")
        if( solveInfo.isSuccess ) {
            val actorLists = solveInfo.getVarValue("ACTORLIST") as Struct
            return actorLists.listSize()
        } else return -1
    }
}