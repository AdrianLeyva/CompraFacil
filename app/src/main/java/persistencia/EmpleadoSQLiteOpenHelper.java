package persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hack03 on 27/05/16.
 */
public class EmpleadoSQLiteOpenHelper extends SQLiteOpenHelper {

    public EmpleadoSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Empleado(Nombre text, Puesto text, Usuario text, Clave text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Empleado");
        db.execSQL("create table Empleado(Nombre text, Puesto text, Usuario text, Clave text)");

    }
}
