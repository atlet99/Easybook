package com.metimol.easybook.database.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.metimol.easybook.database.Book;
import com.metimol.easybook.database.Chapter;

import java.util.List;

public class BookWithChapters {

    @Embedded
    public Book book;

    @Relation(
            parentColumn = "id",
            entityColumn = "bookOwnerId"
    )
    public List<Chapter> chapters;
}