package org.hibernate.examples;

import org.hibernate.examples.inheritance.joinedtable.JoinedTable;
import org.hibernate.examples.inheritance.mappedsuperclass.MappedSuperclass;
import org.hibernate.examples.inheritance.singletable.SingleTable;
import org.hibernate.examples.inheritance.tableperclass.TablePerClass;
import org.hibernate.examples.message.MessageOperationsTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MessageOperationsTests.class,
        MappedSuperclass.class,
        TablePerClass.class,
        SingleTable.class,
        JoinedTable.class})
public class AllTests {
}
