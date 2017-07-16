# Excel Poi Wrapper
* poi를 래핑한 프로젝트
* 외부 라이브러리와의 경계를 감싸고
* 좀 더 추상화된 API로 가독성을 향상
```java
this.excelMakeWrapper.newWorkbook()
                .newSheet()
                .newHead(new ExcelHead("가", "나", "다", "라"))
                .newRow(new ExcelRow("1", "2", "3", "4"))
                .newBody(new ExcelBody(new ExcelRow("11", "22", null, "하하하")))
                .merge(new MergeColumn().rowIdx(1).startColIdx(2).endColIdx(4).getMergeRange())
                .merge(new MergeRow().colIdx(1).startRowIdx(2).endRowIdx(4).getMergeRange())
                .merge(new Merge().startRowIdx(10).endRowIdx(20).startColIdx(10).endColIdx(20).getMergeRange());

OutputStream osw = new FileOutputStream("test.xlsx");
this.excelMakeWrapper.exportWorkbook().write(osw);
```