package com.example.csitgis.lab6_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  StudentAdapter mAdapter;
    private List<Student> studentList = new ArrayList<>();
    private RecyclerView studentsRecyclerView;
    private Button addButton;
    private  DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private  void createStudent(String id,String name){
        db.insertStudent(id,name);
        Student student = db.getStudent(id);
        if(student !=null){
            studentList.add(0,student);
            mAdapter.notifyDataSetChanged();
        }
    }
    private  void  updateStudent(String id,String name,int position){
        Student student = studentList.get(position);
        student.setID(id);
        student.setName(name);

        db.updateStudent(student);
        studentList.set(position ,student);
        mAdapter.notifyItemChanged(position);

    }
    private  void  deleteStudent(int position){
        db.deleteStudent(studentList.get(position));
    }
}
