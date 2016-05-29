package persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by leyva on 27/05/2016.
 */
public class EmpleadosSQLiteOpenHelper extends SQLiteOpenHelper {

    public EmpleadosSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table empleados(nombre text, puesto text, usuario text, clave text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists empleados");
        db.execSQL("create table empleados(nombre text, puesto text, usuario text, clave text)");
    }

}
