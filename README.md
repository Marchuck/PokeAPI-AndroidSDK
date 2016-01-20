# PokeAPI-AndroidSDK

Thanks to contributors of https://github.com/phalt/pokeapi


pokeapi.co V1 wrapped as handy Android API.


#GET pokedex:

new PokedexGET().getVersion(1, new PokeReceiver<Pokedex>() {
            @Override
            public void onReceived(Pokedex pokemon) {
                //got pokedex here
            }
        });
        
#GET single pokemon:

new PokemonGET().getVersion(1, new PokeReceiver<Pokedex>() {
            @Override
            public void onReceived(Pokedex pokemon) {
                //got pokedex here
            }
        });
        
#GET many pokemons:
      
List<Integer> iDs = new ArrayList<>();
for(int j=0;j<20;j++)  iDs.add(j);

new PokemonGET().singlePoke(1, new PokeReceiver<Pokemon>() {
            @Override
            public void onReceived(Pokemon pokemon) {
                //got bulbasaur
            }
        });
