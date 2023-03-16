// 模糊搜索图书简单数据
const getBookList = (params) => {
    return $axios({
        url: '/book/search-book-page',
        method: 'get',
        params
    })
}
