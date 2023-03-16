// 模糊搜索图书简单数据
const sendCodeMsg = (data) => {
    return $axios({
        url: '/user/sendLoginCodeMsg',
        method: 'post',
        data
    })
}

const registerApi = (params) => {
    return $axios({
        url: '/user/register',
        method: 'post',
        data: { ...params }
    })
}
