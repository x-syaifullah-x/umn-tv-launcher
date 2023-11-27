package com.umntv.launcher.main.row.kids.details.e_lerning;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final OverviewItem PRESCHOOL = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "PRESCHOOL",
            "WELCOME TO E-LEARNING PRESCHOOL",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+preschool",
                    null,
                    false
            )
    );

    private static final OverviewItem MATHEMATICS = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "MATHEMATICS",
            "WELCOME TO E-LEARNING MATHEMATICS",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+mathematics+for+kids",
                    null,
                    false
            )
    );

    private static final OverviewItem CODING = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "CODING",
            "WELCOME TO E-LEARNING CODING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+coding+for+kids",
                    null,
                    false
            )
    );

    private static final OverviewItem ENGLISH = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "ENGLISH",
            "WELCOME TO E-LEARNING ENGLISH",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+english+for+kids",
                    null,
                    false
            )
    );

    private static final OverviewItem GRAMMAR = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "GRAMMAR",
            "WELCOME TO E-LEARNING GRAMMAR",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+english+grammar+for+kids",
                    null,
                    false
            )
    );

    private static final OverviewItem MANDARIN = new OverviewItem(
            R.drawable.kids_ic_e_learning,
            R.drawable.kids_ic_e_learning,
            "MANDARIN",
            "WELCOME TO E-LEARNING MANDARIN",
            OverviewItem.SUBTITLE_DEFAULT,
            "Teach or learn with your child/children! E-learning videos, classes, and lessons are available on YouTube",
            new ApkData(
                    "https://www.youtube.com/results?search_query=e+learning+chinese+for+kids",
                    null,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            PRESCHOOL,
            MATHEMATICS,
            CODING,
            ENGLISH,
            GRAMMAR,
            MANDARIN
    );
}
