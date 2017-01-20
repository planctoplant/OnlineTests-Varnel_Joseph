package com.acquisio.basic;

import com.acquisio.basic.java.question01.FizzBuzz;
import com.acquisio.basic.java.question02.TreeNavigation;
import com.acquisio.basic.java.question03.ConvertToBinary;
import com.acquisio.basic.java.question04.IssueResolving;
import com.acquisio.basic.java.question05.Generics;
import com.acquisio.basic.java.question06.Refactoring;
import com.acquisio.basic.java.question07.Debugging;
import com.acquisio.basic.sql.question01.Aggregation;
import com.acquisio.basic.sql.question02.Extraction;

import java.sql.SQLException;

/**
 * Entry point to run all basic test at once.
 */
public class RunAll {
    public static void main(String[] args) throws SQLException {

        // Java subpackage.
        FizzBuzz.main(null);
        TreeNavigation.main(null);
        ConvertToBinary.main(null);
        IssueResolving.main(null);
        Generics.main(null);
        Refactoring.main(null);
        Debugging.main(null);

        // sql subpackage
        Aggregation.main(null);
        Extraction.main(null);
    }
}
