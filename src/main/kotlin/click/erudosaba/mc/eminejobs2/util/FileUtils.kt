package click.erudosaba.mc.eminejobs2.util

import oracle.sql.Mutable
import java.io.File

class FileUtils {

    fun getFiles(dirPath : String) : MutableList<File> {
        val dir = File(dirPath)
        val list = dir.listFiles()
        val result = mutableListOf<File>()
        for(l in list) {
            if(l.isFile) {
                result.add(l)
            }
        }
        return result
    }

    fun getFileName(file : File) : String {
        val baseName = file.name
        return baseName.substring(0,baseName.lastIndexOf('.'))
    }

    fun getFileNames(list : MutableList<File>) : MutableList<String> {
        val result = mutableListOf<String>()

        for(l in list) {
            result.add(getFileName(l))
        }

        return result
    }


}