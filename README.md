# Fluent POI
* poi를 래핑한 프로젝트
* 외부 라이브러리와의 경계를 감싸고
* 좀 더 추상화된 API로 가독성을 향상
```java
this.excelMakeWrapper.newWorkbook()
                .newSheet()
                .addHead(new ExcelHead("가", "나", "다", "라"))
                .addHead(new ExcelRow("1", "2", "3", "4"))
                .addRows(new ExcelRows(new ExcelRow("11", "22", null, "하하하")))
                .merge(new MergeColumn().rowIdx(1).startColIdx(2).endColIdx(4))
                .merge(new MergeRow().colIdx(1).startRowIdx(2).endRowIdx(4))
                .merge(new Merge().startRowIdx(10).endRowIdx(20).startColIdx(10).endColIdx(20));

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.excelMakeWrapper.exportWorkbook().write(osw);
```

* 애노테이션 기반의 객체로 데이터 생성 예제

```java
TestClass target1 = new TestClass("AA", 29, "lcy9002@naver.com", "qqq");
        TestClass target2 = new TestClass("BB", 29, "lcy0202@icloud.com", "sss");
        TestClass target3 = new TestClass("CC", 29, "lcy0202@ticketlink.co.kr", "aaa");

        this.excelMakeWrapper.newWorkbook()
                .newSheet()
                .addHead(ExcelHead.invoke(target1))
                .addHead(ExcelRow.invoke(target2))
                .addRows(ExcelRows.invoke(Arrays.asList(target1, target2, target3)));

        OutputStream osw = new FileOutputStream("test.xlsx");
        this.excelMakeWrapper.exportWorkbook().write(osw);
```