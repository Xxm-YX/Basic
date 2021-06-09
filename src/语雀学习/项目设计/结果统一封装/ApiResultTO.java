package 语雀学习.项目设计.结果统一封装;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiResultTO<T extends Serializable> extends BaseTO {

    private static final long serialVersionUID = 4785961935752148785L;

//    /**
//     * 是否操作成功
//     */
//    @ApiModelProperty(value = "是否操作成功", required = true, example = "true")
//    private boolean success;
//    /**
//     * 错误码
//     */
//    @ApiModelProperty(value = "错误码", required = true, example = "0001")
//    private Integer errorCode;

}
