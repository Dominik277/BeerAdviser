package beer.adviser;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {Note.class},version = 1)
public abstract class Notedatabase {

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
                SyncStateContract.Constants.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public void cleanUp(){
        noteDB = null;
    }

}
