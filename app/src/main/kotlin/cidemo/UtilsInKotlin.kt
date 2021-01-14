package cidemo

import alice.tuprolog.Prolog
import alice.tuprolog.Struct

object UtilsInKotlin {
    val engine = Prolog()

    fun loadRules() {
        try {
            val userDirPath = System.getProperty("user.dir").replace("\\","/")
            //userDirPath is C:\Didattica2018Work\cidemo\app when run the test (?)
              println("UtilsInKotlin | loadRules userDirPath= $userDirPath")
            val sol0 = engine.solve("consult('./sysRules.pl').")
            println("UtilsInKotlin | loadRules load sysRules.pl= $sol0")
            if( sol0.isHalted ){ //in the case of testing
                val sol1 = engine.solve("consult('../sysRules.pl').")
                println("UtilsInKotlin | loadRules load sysRules.pl= $sol1")
            }
            val sol2 = engine.solve("consult('./demo0.pl').") //tuprolog consult changes the dir
            println("UtilsInKotlin | loadRules load demo0.pl= $sol2")
        } catch (e: Exception) {
            println("UtilsInKotlin | loadRules ERROR " + e.message)
        }        
    }
    
    fun showSystemConfiguration() {
        try {
              engine.solve("showSystemConfiguration.")
        } catch (e: Exception) {
            println("UtilsInKotlin | showSystemConfiguration ERROR " + e.message)
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