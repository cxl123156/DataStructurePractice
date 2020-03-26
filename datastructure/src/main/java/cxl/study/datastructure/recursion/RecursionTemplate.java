package cxl.study.datastructure.recursion;

public class RecursionTemplate {

    private static final int MAX_LEVEL = 10;

    /**
     * 递归模板
     */
    public void recursion(int level,int params1,int params2){

        // 终结条件
        if(level > MAX_LEVEL){
            return;
        }

        // 当前层处理逻辑
        processLogic(params1,params2);

        // 下探到下一层
        recursion(level+1,params1,params2);

        // 清理当前层数据

    }

    private void processLogic(int params1, int params2) {
        // 处理逻辑
    }

}
