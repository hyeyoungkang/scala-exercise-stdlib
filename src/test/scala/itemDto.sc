case class ItemDto(
                    itemId: Int,
                    standardCategoryId : Int,
                    name : String
                  )
case class CategoryDto(
                        id: Int,
                        categoryId : Int
                      )

val itemDto: List[ItemDto] = List(ItemDto(1,100,"name"), ItemDto(2,200,"name2"))
val categoryDto: List[CategoryDto] = List(CategoryDto(10,100), CategoryDto(11,200))

//itemDto.filter( i => (categoryDto.filter( c => c.categoryId!= i.standardCategoryId ))).map(_)
itemDto.filterNot(i => categoryDto.exists(c=>c.categoryId == i.standardCategoryId))

