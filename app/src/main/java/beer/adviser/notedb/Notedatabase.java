package beer.adviser.notedb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import beer.adviser.Constants;

@Database(entities = {Note.class},version = 1)
public abstract class Notedatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    private static Notedatabase noteDB;

    public static Notedatabase getInstance(Context context){
        if (null == noteDB){
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static Notedatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context,
                Notedatabase.class,
                Constants.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public void cleanUp(){
        noteDB = null;
    }

}
