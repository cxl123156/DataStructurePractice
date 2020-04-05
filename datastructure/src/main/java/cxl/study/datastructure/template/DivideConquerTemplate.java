package cxl.study.datastructure.template;

public class DivideConquerTemplate {

    /**
     * 分治模板代码
     */
    int result;
    public int divideConquer(Integer problem,int params1,int params2){

        // 终止条件
        if(problem == null){
            System.out.println(result);
            return 1;
        }

        // 准备数据
        int data = prepareData(problem);
        int[] subproblems = split_problem(problem, data);

        // 处理子问题
        int subresult1 = this.divideConquer(subproblems[0], params1,params2);
        int subresult2 = this.divideConquer(subproblems[1], params1,params2);
        int subresult3 = this.divideConquer(subproblems[2], params1,params2);

        // 处理并生成最终结果
        result = process_result(subresult1, subresult2, subresult3);

        // 清理当前层数据

        return result;
    }

    private int process_result(int subresult1, int subresult2, int subresult3) {
        return 0;
    }

    private int[] split_problem(Integer problem, int data) {
        return new int[0];
    }

    private int prepareData(Integer problem) {
        return 0;
    }

}
