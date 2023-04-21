# Buzy Card
Pequena aplicação com JetPack Compose, e apenas cards estaticos , permitindo expandir para mostrar outros cards menores


## Motivação
Aprender o uso de criação de interfaces com JetPack Compose

## Feature
- As variáveis usamos conceito muito parecido com Observable
- Temos uma extensão com nome remember que recebe closure e dentro dela usamos mutableStateOf com o valor desejado
- Para atualizar usamos o value


```kotlin
val showPortifolio = remember {
        mutableStateOf(value = false)
    }

    fun handleShowPortifolio() {
        showPortifolio.value = !showPortifolio.value
    }



```
##

- Usamos bastante Surface que no caso é tipo um container que possui alguns modificadores próprios para construímos nosso containers
- Cada componente tem seu Modificador próprio muito parecido com o Flutter

```Kotlin
Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
           Card(modifier = Modifier
               .width(200.dp)
               .height(390.dp)
               .padding(12.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
               ) {
               Column(modifier = Modifier.size(300.dp),
                      verticalArrangement = Arrangement.Top,
                      horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                   CreateProfileImg()
                   Divider()
                   CreateTextDescriptionProfile()
                   Button(onClick = { handleShowPortifolio() }) {
                        Text(text = "Protifolio", style = MaterialTheme.typography.button)
                   }
                   if(showPortifolio.value) {
                        Content()
                   }

               }

           }
    }


```

##
- Podemos componentizar usando os conceitos do Decorator no caso nome e Composable
- Podemos passar parâmetros opcionais para nosso componente se tornar mais flexível possível
- Repare no componente CreateProfileImg a foto assume tamanhos diferentes conforme a necessidade

```kotlin

   // componente 1
  Column(modifier = Modifier.size(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
             ) {
            // aqui a imagem tera o tamanho padrão determinado no Composable 
            CreateProfileImg()
         }

 }
 
  //componente 2
  LazyColumn(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
         items(data) { item ->
             Card(modifier = Modifier
                 .padding(vertical = 10.dp, horizontal = 15.dp)
                 .fillMaxWidth(),
                  elevation = 4.dp,
                 shape = RoundedCornerShape(corner = CornerSize(size = 7.dp))
                 ) {
                 Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                     // aqui a imagem ficara menor
                     CreateProfileImg(modifier = Modifier.size(50.dp)) 
                     Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                         Text(text = item, fontWeight = FontWeight.Bold)
                         Text(text = "A great project")
                     }
                 }
             }
         }
     }
     
// uso o parametro modifier para deixar flexivel
@Composable
private fun CreateProfileImg(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .size(150.dp),
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        shape = CircleShape,
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}



```
##
- Para lidar com listas usamos LazyColumn
- Abaixo exemplo como lidar com listas
- Dentro da closure do LazyColuns temos acesso ao items e nele que possuo cada item da lista que determinamos na data do Portifolio

```kotlin

//componente 1
Surface(
       modifier = Modifier
          .padding(2.dp)
          .fillMaxHeight()
          .fillMaxWidth(),
          shape = RoundedCornerShape(
                  corner = CornerSize(7.dp)
              ),
              border = BorderStroke(width = 1.dp,color= Color.LightGray)
              ) {
              Portifolio(data =  listOf("project1","project2","projet3","project4","project5"))
        }

@Composable
fun Portifolio(data: List<String>) {
     LazyColumn(modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)) {
         items(data) { item ->
             Card(modifier = Modifier
                 .padding(vertical = 10.dp, horizontal = 15.dp)
                 .fillMaxWidth(),
                  elevation = 4.dp,
                 shape = RoundedCornerShape(corner = CornerSize(size = 7.dp))
                 ) {
                 Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                     CreateProfileImg(modifier = Modifier.size(50.dp))
                     Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                         Text(text = item, fontWeight = FontWeight.Bold)
                         Text(text = "A great project")
                     }
                 }
             }
         }
     }
}

 

```














